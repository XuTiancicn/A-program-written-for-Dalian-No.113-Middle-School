import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane

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
        val button = JButton("开始执行")
        frame.add(button)

        // 为按钮添加点击事件
        button.addActionListener {
            JOptionPane.showMessageDialog(frame, "执行完毕")
        }

        frame.setVisible(true)
    } else {
        println("$os")
    }
}