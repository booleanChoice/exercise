package com.booleanchoice.exercise.algorithm.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 雀魂启动！
 *
 *
 * 描述
 *
 * 根据一款叫做雀魂的麻将游戏，简化了游戏规则，具体如下：
 * 1.总共有36张牌，每张牌是1~9。每个数字4张牌。
 * 2.如果取出14张牌满足如下条件，即算作和牌：
 * ①14张牌中有2张相同数字的牌，称为雀头。
 * ②除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。
 *
 * 注：顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）。
 *
 * 从36张牌中抽取了13张牌，那么在剩下的23张牌中再取一张牌，取到哪几种数字牌可以和牌？
 *
 *
 * 样例
 *
 * 样例 1:
 * 输入:
 * [1, 1, 1, 2, 2, 2, 5, 5, 5, 6, 6, 6, 9]
 * 输出:
 * [9]
 * 说明：可以组成1,2,5,6的4个刻子和9的雀头。
 *
 * 样例 2:
 * 输入:
 * [1, 1, 1, 1, 2, 2, 3, 3, 5, 6, 7, 8, 9]
 * 输出:
 * [4, 7]
 * 说明：
 * 用1做雀头，组123,123,567或456,789的四个顺子。
 *
 */
public class MajsoulStart {

    public class Solution {

        /**
         * @param cards: A list of cards.
         * @return: A list of feasible solution.
         */
        public List<Integer> getTheNumber(int[] cards) {
            // write your code here
            List<Integer> rs = new ArrayList<>();
            rs.add(0);
            // 参数非法
            if (cards == null || cards.length != 13) {
                return rs;
            }
            rs.clear();

            List<Integer> noneCard = new ArrayList<>();

            // 雀头的数字
            int head = -1;
            // cardNum -> count
            Map<Integer, Integer> buckets = new HashMap<>();

            return rs;
        }
    }
}
