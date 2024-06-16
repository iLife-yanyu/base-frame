package com.yanyu.libs.baseframe.util

import com.yanyu.libs.klog.KLog
import com.yanyu.libs.baseframe.callback.ICallback
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.util.LinkedList
import java.util.Scanner

object FileUtil {

    private const val TAG: String = "FileUtil"

    fun <E> writeText(file: File, list: List<E>) {
        KLog.e(TAG, "writeText: ${file.absolutePath}")
        file.parentFile?.let {
            if (!it.exists()) {
                val mkdirs = it.mkdirs()
                KLog.d(TAG, "mkdirs: ${it.absolutePath} mkdirs success is $mkdirs")
            }
        }
        if (file.exists()) {
            file.delete()
        }
        file.createNewFile()
        var stream: FileOutputStream? = null
        try {
            stream = FileOutputStream(file, true)
            list.forEach {
                val text = "${GsonUtil.toJson(it)}\n"
                stream.write(text.toByteArray())
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
            KLog.e(TAG, e)
        }
        finally {
            stream?.close()
        }
    }

    fun <E> readText(targetFile: File, clazz: Class<E>): LinkedList<E> {
        val linkedList: LinkedList<E> = LinkedList()
        var stream: FileInputStream? = null
        try {
            stream = FileInputStream(targetFile)
            readOnCallback(stream, object : ICallback<String> {
                override fun onCallback(data: String) {
                    val obj = GsonUtil.fromJson(data, clazz)
                    if (obj != null) {
                        linkedList.add(obj)
                    }
                    else {
                        KLog.d(TAG, "readText: parseError ${clazz.simpleName} $data")
                    }
                }

            })
        }
        catch (e: Exception) {
            e.printStackTrace()
            KLog.e(TAG, "read exception ${e.message}")
        }
        finally {
            stream?.close()
        }
        return linkedList
    }

    @Throws(Exception::class)
    fun readOnCallback(stream: InputStream, iCallback: ICallback<String>) {
        val scanner = Scanner(stream)
        while (scanner.hasNextLine()) {
            iCallback.onCallback(scanner.nextLine())
        }
        scanner.close()
    }
}
