package org.example

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val node1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(9)
        }
    }
    val node2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4).apply {
                next = ListNode(5).apply {
                    next = ListNode(8).apply {
                        next = ListNode(10)
                    }
                }
            }
        }
    }
    println(LeeCode75.middleNode(node1).toString())
    println(LeeCode75.middleNode(node2).toString())
    println(LeeCode75.middleNode(null).toString())
//    println(LeeCode75.isSubsequence("axc", "ahbgdc"))
//    println(LeeCode75.isSubsequence("acb", "ahbgdc"))
}





