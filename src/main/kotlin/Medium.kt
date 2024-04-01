package org.example


object Medium {
    // Medium 3. Longest Substring Without Repeating Characters
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var result = 0
        var start = 0
        s.forEachIndexed { i, it ->
            if (map.contains(it)) {
                start = maxOf(start, map[it]!! + 1)
            }
            map[it] = i
            result = maxOf(result, i - start + 1)
        }
        return result
    }

    // 5. Longest Palindromic Substring
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s
        var longestPalindrome = ""
        for (i in s.indices) {
            for (j in i + 1..s.length) {
                val substring = s.substring(i, j)
                if (palindrome(substring) && substring.length > longestPalindrome.length) {
                    longestPalindrome = substring
                }
            }
        }
        return longestPalindrome
    }

    fun palindrome(s: String): Boolean {
        return when (s.length) {
            0 -> false
            1 -> true
            else -> {
                var i = 0
                var j = s.length - 1
                while (i < j) {
                    if (s[i] != s[j])
                        return false
                    i++
                    j--
                }
                true
            }
        }

    }

    // 5. Longest Palindromic Substring -> Expand Around Center
    fun longestPalindrome2(s: String): String {
        if (s.length < 2) return s
        var maxString = s.substring(0, 1)
        for (i in s.indices) {
            val odd = expandFromCenter(s, i, i)
            val even = expandFromCenter(s, i, i + 1)
            if (odd.length > maxString.length) {
                maxString = odd
            }
            if (even.length > maxString.length) {
                maxString = even
            }
        }
        return maxString
    }

    private fun expandFromCenter(s: String, leftStart: Int, rightStart: Int): String {
        var l = leftStart
        var r = rightStart
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return s.substring(l + 1, r)
    }
}
// abccba