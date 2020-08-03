package cn.andios.kotlin.objectExpression

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.JButton
import javax.swing.JFrame

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

fun main(args: Array<String>) {
    val jFrame = JFrame("My JFrame")
    val jButton = JButton("My JBuffon")

    jFrame.addWindowListener(object: WindowListener {
        override fun windowDeiconified(e: WindowEvent?) {
            println("window Deiconified")
        }

        override fun windowClosing(e: WindowEvent?) {
            println("window closing")
        }

        override fun windowClosed(e: WindowEvent?) {
            println("window closed")
        }

        override fun windowActivated(e: WindowEvent?) {
            println("window activated")
        }

        override fun windowDeactivated(e: WindowEvent?) {
            println("window deactivated")
        }

        override fun windowOpened(e: WindowEvent?) {
            println("window opened")
        }

        override fun windowIconified(e: WindowEvent?) {
            println("window iconified")
        }

    })

    // 如果对象是java函数式表达式接口的一个实例（即只拥有一个抽象方法的接口）
    // 那么可以通过lambda表达式来调用，其中lambda表达式前面加上接口的类型
    jButton.addActionListener(object: ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            println("button pressed")
        }
    })

    jButton.addActionListener { println("button pressed") }

    val listener = ActionListener { println("hello") }
    println(listener.javaClass)
    println(listener.javaClass.superclass)

    println(listener::class.java)
    println(listener::class.java.superclass)

    jFrame.add(jButton)
    jFrame.pack()
    jFrame.isVisible = true
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}
