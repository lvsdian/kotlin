package cn.andios.kotlin.expression

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

    jButton.addActionListener(object: ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            println("button pressed")
        }
    })

    jFrame.add(jButton)
    jFrame.pack()
    jFrame.isVisible = true
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}
