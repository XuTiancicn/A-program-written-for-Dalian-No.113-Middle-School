import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.IOException;

fun getCurrentSystem(): String {
    val osName = System.getProperty("os.name")
    return when {
        osName.startsWith("Windows") -> "Windows"
        else -> "除 Windows 外其他系统不可用"
    }
}

fun main() {
    val os = getCurrentSystem()
    if (os == "Windows") {
        // 创建一个空白窗口
        val frame = JFrame()
        frame.setSize(300, 300)

        // 创建一个按钮
        val button = JButton("开始复制")
        frame.add(button)

        // 为按钮添加点击事件
        button.addActionListener {
            try {
                val file = File("main.jar") // 假设main.jar在当前目录
                val destFile = File("C:/main.jar") // 目标路径
                file.copyTo(destFile) // 复制文件
                JOptionPane.showMessageDialog(frame, "复制成功") // 提示复制成功
            } catch (e: IOException) {
                JOptionPane.showMessageDialog(frame, "复制失败：" + e.message) // 提示复制失败
            }
        }

        frame.setVisible(true)
    } else {
        println("$os")
    }
}