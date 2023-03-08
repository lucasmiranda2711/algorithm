package com.dutra.algorithm.daimo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
public class SelectionSortTest {

    private final SelectionSort selectionSort = new SelectionSort();
    int[] data = { 49, 73, 22, 34, 66, 55, 71, 4, 53, 15, 62, 81, 80, 9, 96, 8, 85, 56, 57, 89 };
    int[] sortedData = Arrays.stream(data).sorted().toArray();

    @Param({"10","100","1000"})
    public int iterations;


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(batchSize = -1, iterations = 3, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(batchSize = -1, iterations = 10, time = 10, timeUnit = TimeUnit.MILLISECONDS)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void test() throws Exception {
        selectionSort.sort(data);
        System.out.println("Sorted data: ");
        System.out.println(Arrays.toString(data));
        Assertions.assertArrayEquals(data, sortedData);
    }



    @Test
    public void shouldSelectSort() throws IOException {
        String[] argv = {};
        org.openjdk.jmh.Main.main(argv);
    }

}