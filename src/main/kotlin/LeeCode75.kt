package org.example

object LeeCode75 {

    // [Day 01] 什麼是LeetCode 75？ 以及 1480. Running Sum of 1d Array
    fun runningSum(nums: IntArray): IntArray {
        for (i in 1..<nums.size) {
            nums[i] += nums[i - 1]
        }
        return nums
//        val result = IntArray(nums.size)
//        var temp = 0
//        nums.forEachIndexed { index, i ->
//            temp += i
//            result[index] = temp
//        }
//        return result
    }

    // [Day 02] LeetCode 75 - 724. Find Pivot Index
    fun pivotIndex(nums: IntArray): Int {
        var totalSum = 0
        var leftSum = 0
        nums.forEach {
            totalSum += it
        }
        nums.forEachIndexed { i, it ->
            if (leftSum * 2 == totalSum - it) {
                return i
            }
            leftSum += it
        }
        return -1
    }

    // [Day 03] LeetCode 75 - 205. Isomorphic Strings
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val sArray = IntArray(96)
        val tArray = IntArray(96)
        for (i in s.indices) {
            val sChar = s[i].code - 31
            val tChar = t[i].code - 31

            if (sArray[sChar] != tArray[tChar]) return false

            sArray[sChar] = i + 1
            tArray[tChar] = i + 1
        }
        return true
    }

    // [Day 04] LeetCode 75 - 392. Is Subsequence
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                i++
            }
            j++
        }
        return i == s.length
    }

    // [Day 05] LeetCode 75 - 21. Merge Two Sorted Lists
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val result = ListNode(Int.MIN_VALUE)
        var resultTemp: ListNode = result
        var temp1: ListNode? = list1
        var temp2: ListNode? = list2
        while (temp1 != null && temp2 != null) {
            if (temp1.`val` < temp2.`val`) {
                resultTemp.next = temp1
                resultTemp = resultTemp.next!!
                temp1 = temp1.next
            } else {
                resultTemp.next = temp2
                resultTemp = resultTemp.next!!
                temp2 = temp2.next
            }
        }
        if (temp1 != null) {
            resultTemp.next = temp1
        }
        if (temp2 != null) {
            resultTemp.next = temp2
        }
        return result.next
    }

    // [Day 06] LeetCode 75 - 206. Reverse Linked List
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var prev: ListNode? = null
        var curr: ListNode? = head
        var next: ListNode? = null
        while (curr != null) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }

    // [Day 07] LeetCode 75 - 876. Middle of the Linked List
    fun middleNode(head: ListNode?): ListNode? {
//        var length = 0
//        var temp: ListNode? = head
//        while (temp != null) {
//            length++
//            temp = temp.next
//        }
//        val key = length / 2
//        var i = 0
//        var result: ListNode? = head
//        while (i < key) {
//            result = result?.next
//            i++
//        }
//        return result
//        val list = mutableListOf<ListNode>()
//        var length = 0
//        var temp: ListNode? = head
//        while (temp != null) {
//            list.add(temp)
//            temp = temp.next
//            length++
//        }
//        return list[length / 2]
        var temp1 = head
        var temp2 = head
        while (temp1 != null) {
            temp1 = temp1.next
            if (temp1 != null) {
                temp1 = temp1.next
                temp2 = temp2!!.next
            }
        }
        return temp2
    }

    // [Day 08] LeetCode 75 - 142. Linked List Cycle II
    fun detectCycle(head: ListNode?): ListNode? {
        val tempList = mutableListOf<ListNode>()
        var temp: ListNode? = head
        var i = 0
        while (temp != null) {
            tempList.add(i, temp)
            if (tempList.contains(temp.next)){
                return temp.next
            }
            temp = temp.next
            i++
        }
        return null
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        var string = ""
        var temp: ListNode? = this
        while (temp != null) {
            string += "${temp.`val`}, "
            temp = temp.next
        }
        return string
    }
}