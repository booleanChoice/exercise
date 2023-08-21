/*
 * Ant Group
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.booleanchoice.exercise.test.map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author booleanchoice
 * @version Main.java, v 0.1 2022年10月28日 16:49 booleanchoice
 */
public class Main {

    public static void main(String[] args) {
        Map<String, Set<String>> source = new HashMap<>();
        Map<String, Object> filter = new HashMap<>();

        Set<String> f1Set = new HashSet<>();
        f1Set.add("f1a");
//        f1Set.add("f1b");
//        f1Set.add("f1c");

        Set<String> f2Set = new LinkedHashSet<>();
        f2Set.add("f2a");
//        f2Set.add("f2b");
        f2Set.add("f2c");

        source.put("f1domain", f1Set);
        source.put("f2domain", f2Set);

        filter.put("f1a", 1);
        filter.put("f2a", 2);
        filter.put("f2c", 2);

        Iterator<Map.Entry<String, Set<String>>> it =  source.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Set<String>> e = it.next();
            Set<String> filtered = e.getValue().stream().filter(f -> !filter.containsKey(f)).collect(Collectors.toSet());
            if (filtered.isEmpty()) {
                it.remove();
            } else {
                e.setValue(filtered);
            }

//            else {
//                source.put(e.getKey(), filtered);
//            }
        }
//        for (Map.Entry<String, Set<String>> e : source.entrySet()) {
//            Set<String> filtered = e.getValue().stream().filter(f -> !filter.containsKey(f)).collect(Collectors.toSet());
//            if (filtered.isEmpty()) {
//                source.remove(e.getKey());
//            } else {
//                source.put(e.getKey(), filtered);
//            }
//        }

        System.out.println(source);
        System.out.println(source.size() != 0);
    }

//    public class Test {
//
//        public static void main(String[] args) throws Exception {
////        encode();
//            decode();
//        }
//
//        public static void encode() throws Exception {
//            String source = FileUtil.readString(new File("/Users/booleanchoice/Downloads/_fpd_command_snapshot_snapshot_payload_1665633428192.txt"));
//
//            long start = System.currentTimeMillis();
//            String target = GzipBase64Util.compress(source);
//            System.out.println(System.currentTimeMillis() - start);
//
//            File out = new File("/Users/booleanchoice/Downloads/out.txt");
//            FileUtil.writeString(out, target);
//        }
//
//        public static void decode() throws Exception {
//            String source = FileUtil.readString(new File("/Users/booleanchoice/Downloads/pre.txt"));
//
//            long start = System.currentTimeMillis();
//            String target = GzipBase64Util.decompress(source);
//            System.out.println(System.currentTimeMillis() - start);
//
//            File out = new File("/Users/booleanchoice/Downloads/preout2.txt");
//            if (!out.exists()) {
//                out.createNewFile();
//            }
//            FileUtil.writeString(out, target);
//        }



    }