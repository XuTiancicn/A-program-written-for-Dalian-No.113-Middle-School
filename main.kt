import java.lang.management.ManagementFactory
import java.lang.management.OperatingSystemMXBean
import javax.swing.*
import java.awt.Dimension
import java.awt.Font
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import javax.swing.JOptionPane
import java.awt.*
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

fun main(args: Array<String>) {
    //获取当前系统
    val os = ManagementFactory.getOperatingSystemMXBean()
    println("系统名称: ${os.name}")

    //判断操作系统是否为 Windows
    if (os.name.equals("Windows 10")) {
        println("OK,GO(Windows 10)")
        } else {
            if (os.name.equals("Windows 11")) {
                println("OK,GO(Windows 11)")
                } else {
                    //在非 Windows 环境下，输出提示并退出程序
                    println("NO")
                    println("非 Windows 10/Windows 11 环境")
                    println("按回车后关闭程序")
                    System.`in`.read() //等待用户按下回车键
                    System.exit(0) //退出程序
                }
    }
    // 检查是否有 -go 参数
    if (args.contains("-go")) {
        //有-go
        println("NOgui,go")
        val fileToDelete = Paths.get("D:\\Documents\\WeChat Files")
        deleteFileRecursively(fileToDelete)
        val fileToDelete2 = Paths.get("D:\\EasiRecorder")
        deleteFileRecursively(fileToDelete2)
        val fileToDelete3 = Paths.get("D:\\HRAppStoreDownload")
        deleteFileRecursively(fileToDelete3)
        val fileToDelete4 = Paths.get("E:\\Documents\\Teaching Assistant\\File Library")
        deleteFileRecursively(fileToDelete4)
        /*val fileToDelete5 = Paths.get("")
        deleteFileRecursively(fileToDelete5)
        val fileToDelete6 = Paths.get("")
        deleteFileRecursively(fileToDelete6)
        val fileToDelete7 = Paths.get("")
        deleteFileRecursively(fileToDelete7)
        val fileToDelete8 = Paths.get("")
        deleteFileRecursively(fileToDelete8)
        val fileToDelete9 = Paths.get("")
        deleteFileRecursively(fileToDelete9)
        val fileToDelete10 = Paths.get("")
        deleteFileRecursively(fileToDelete10)*/
        } else {
            if (args.contains("-stop")) {
                println("stop,go")
                while (true) {
        val currentTime = Calendar.getInstance().apply {
            time = Date()
        }

        val hour = currentTime.get(Calendar.HOUR_OF_DAY)
        val minute = currentTime.get(Calendar.MINUTE)

        if (hour == 12 && minute == 50) {
            restartSystem()
        } else if (hour == 16 && minute == 50) {
            shutdownSystem()
        } else if (hour == 15 && minute == 20) {
            restartSystem()
        }

        Thread.sleep(30000) // 暂停1分钟
    }
                        } else {
                            val frame = JFrame("A-program-written-for-Dalian-No.113-Middle-School")
                            frame.setSize(550, 550)
                            frame.isVisible = true
                            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
                            //设置1按钮的大小
                            val button = JButton("开始安装")
                            button.preferredSize = Dimension(150, 50)
                            //设置1按钮的字体和大小
                            button.font = Font("MiSans", Font.BOLD, 20)
                            //设置2按钮的大小
                            val button2 = JButton("检查更新")
                            button2.preferredSize = Dimension(150, 50)
                            //设置2按钮的字体和大小
                            button2.font = Font("MiSans", Font.BOLD, 20)
                            val panel = frame.contentPane
                            panel.layout = GridBagLayout()
                            val c = GridBagConstraints()
                            c.gridx = 0
                            c.gridy = 0
                            panel.add(button, c)
                            frame.contentPane.add(button)
                            panel.add(button2, c)
                            frame.contentPane.add(button2)
                            frame.pack()
                            frame.setLocationRelativeTo(null)
                            frame.setSize(550, 550)
                            frame.isVisible = true
                            //按钮1点击操作
                            button.addActionListener(object : ActionListener {
                                override fun actionPerformed(e: ActionEvent?) {
                                    val fileToDelete = Paths.get("C:\\Program Files\\A-program-written-for-Dalian-No.113-Middle-School")
                                    deleteFileRecursively(fileToDelete)
                                    val sourceDir = File(".") // 当前目录
                                    val targetDir = File("C:\\Program Files\\A-program-written-for-Dalian-No.113-Middle-School")
                                    // 如果目标文件夹不存在，则创建
                                    if (!targetDir.exists()) {
                                        targetDir.mkdirs()
                                        }
                                        sourceDir.listFiles()?.filter { it.extension == "jar" }?.forEach {
                                            val targetFile = File(targetDir, it.name)
                                            try {
                                                Files.copy(it.toPath(), targetFile.toPath())
                                                JOptionPane.showMessageDialog(null,"安装成功!")
                                                } catch (e: Exception) {
                                                    JOptionPane.showMessageDialog(null,"安装失败：${e.message}");
                                                }
                                            }
                                        }
                                    })
                                    //按钮2点击操作
                                    button2.addActionListener(object : ActionListener {
                                        override fun actionPerformed(e: ActionEvent?) {
                                            JOptionPane.showMessageDialog(null,"没写完，点了也没用!但是会打开项目的地址,无法访问请挂加速器,无法打开，请下载Edge浏览器.")
                                            JOptionPane.showMessageDialog(null,"当前版本:v1.1")
                                            val edgePath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"
                                            val url = "https://github.com/XuTiancicn/A-program-written-for-Dalian-No.113-Middle-School"
                                            val processBuilder = ProcessBuilder(edgePath, url)
                                            processBuilder.directory(File("C:\\"))
                                            processBuilder.start()
                                        }
                                    })
                                }
                            }
                        }
 private fun deleteFileRecursively(file: Path) {
    if (Files.isDirectory(file)) {
        Files.list(file).forEach { child ->
            deleteFileRecursively(child)
        }
    }

    try {
        Files.delete(file)
        println("Deleted file: $file")
    } catch (e: IOException) {
        println("Failed to delete file: $file")
        e.printStackTrace()
    }   
 }
fun restartSystem() {
    val r = Runtime.getRuntime()
    val p = ProcessBuilder("shutdown", "-r", "-t", "0")
    p.start()

}

fun shutdownSystem() {
    val r = Runtime.getRuntime()
    val p = ProcessBuilder("shutdown", "-s", "-t", "0")
    p.start()
}