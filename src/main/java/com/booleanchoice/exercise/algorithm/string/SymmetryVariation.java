package com.booleanchoice.exercise.algorithm.string;

import java.util.Scanner;

/**
 * 对称变异
 *
 * 种植兰花
 *
 * 为了更好地开展副业，蒜头君决定种植魔法兰花，魔法兰花的品种由若干个大写字母组成的字符串S表示, 魔法兰花种下之后可以自主 “对称变异”，例如种下一株兰花品种JSK，它可能向左 “对称变异” 为品种KSJJSK，或者向右 “对称变异” 为品种JSKKSJ。
 *
 * 蒜头君邀请你去参观他的兰花种植基地, 你看到其中
 * 1
 *  朵魔法兰花的品种为
 * S
 * ，请问该品种的魔法兰花最多可能变异了多少次。
 *
 * 输入格式
 * 输入为
 * 1
 *  行，为一个只包含大写字母的非空字符串
 * S
 * ，长度不超过
 * 10000
 * ，表示这朵魔法兰花的品种。
 *
 * 输出格式
 * 输出为一行, 只有一个整数, 表示魔法兰花最多变异的次数。
 */
public class SymmetryVariation {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        // 输入字符串长度
        int len = a.length();
        // 结果
        int rs = 0;
        // 输入长度为0、1或奇数，不可能有变异，直接返回0
        if (len <= 1 || len % 2 != 0) {
            System.out.println(rs);
            return;
        }
        // 中位数
        int mid = len;

        while (mid % 2 == 0) {
            // 获取中位数
            mid = len / 2;
            // 根据中位数取字符串中间的索引
            int i = mid - 1;
            int j = mid;
            while (i >= 0) {
                if (a.charAt(i) != (a.charAt(j))) {
                    break;
                }
                if (i == 0) {
                    // 左右字符串匹配了
                    rs++;
                }
                // 移动索引
                i--;
                j++;
            }
            // 检查一半长度的字符串
            len = len / 2;
        }
        System.out.println(rs);
    }

}
