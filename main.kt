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

fun main() {
    //获取当前系统
    val os = ManagementFactory.getOperatingSystemMXBean()
    println("系统名称: ${os.name}")

    //判断操作系统是否为 Windows
    if (os.name.equals("Windows")) {
        //在非 Windows 环境下，输出提示并退出程序
        println("NO")
        println("非 Windows 环境")
        println("按回车后关闭程序")
        System.`in`.read() //等待用户按下回车键
        System.exit(0) //退出程序
    } else {
        //在 Windows 环境下，执行某些代码
        println("OK,GO")   
    }
    val frame = JFrame("A-program-written-for-Dalian-No.113-Middle-School")
    frame.setSize(550, 550)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    //设置按钮的大小
    val button = JButton("开始安装")
    button.preferredSize = Dimension(150, 50)
    //设置按钮的字体和大小
    button.font = Font("微软雅黑", Font.BOLD, 16)
    val panel = frame.contentPane
    panel.layout = GridBagLayout()
    val c = GridBagConstraints()
    c.gridx = 0
    c.gridy = 0
    panel.add(button, c)
    frame.contentPane.add(button)
    frame.pack()
    frame.setLocationRelativeTo(null)
    frame.setSize(550, 550)
    frame.isVisible = true
    //按钮点击操作
     button.addActionListener(object : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            val sourceFile = File("main.jar") // 程序执行目录下的main.jar
    val targetDir = File("C:\\Program Files\\A-program-written-for-Dalian-No.113-Middle-School") // 目标文件夹

    // 如果目标文件夹不存在，则创建
    if (!targetDir.exists()) {
        targetDir.mkdirs()
    }

    // 复制文件
    try {
        val targetFile = File(targetDir, sourceFile.name)
        Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
        JOptionPane.showMessageDialog(null,"安装成功!")
    } catch (e: Exception) {
       JOptionPane.showMessageDialog(null,"安装失败：${e.message}")
    }
        }            
    })
}