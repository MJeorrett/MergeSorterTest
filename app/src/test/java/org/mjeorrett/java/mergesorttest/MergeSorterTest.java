package org.mjeorrett.java.mergesorttest;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 21/11/2016.
 */

public class MergeSorterTest {

    @Test
    public void arrayLengthOne() {

        int[] input = { 3 };
        int[] expected = { 3 };
        int[] actual = MergeSorter.sort( input );

        assertArrayEquals( expected, actual );
    }

    @Test
    public void preSortedArrayLengthTwo() {

        int[] input = { 3, 4 };
        int[] expected = { 3, 4 };
        int[] actual = MergeSorter.sort( input );

        assertArrayEquals( expected, actual );
    }

    @Test
    public void unsortedArrayLengthTwo() {

        int[] input = { 7, 3 };
        int[] expected = { 3, 7 };
        int[] actual = MergeSorter.sort( input );

        assertArrayEquals( expected, actual );
    }

    @Test
    public void unsortedArrayLengthThree() {

        int[] input = { 2, 1, 7 };
        int[] expected = { 1, 2, 7 };
        int[] actual = MergeSorter.sort( input );

        assertArrayEquals( expected, actual );
    }

    @Test
    public void unsortedArrayLengthFour() {

        int[] input = { 2, 1, 7, 3 };
        int[] expected = { 1, 2, 3, 7 };
        int[] actual = MergeSorter.sort( input );

        assertArrayEquals( expected, actual );
    }

    @Test
    public void unsortedArrayLengthEleven() {

        int[] input = { 2, 1, 7, 3, 6, 9, 12, 1, 4, 10, 11 };
        int[] expected = { 1, 1, 2, 3, 4, 6, 7, 9, 10, 11, 12 };
        int[] actual = MergeSorter.sort( input );

        assertArrayEquals( expected, actual );
    }

    @Test
    public void massiveArray() {

        int n = 10000000;

        int[] input = new int[n];

        Random rng = new Random();

        for ( int i = 0; i < n; i++ ) {

            input[i] = rng.nextInt();
        }

        int[] actual = MergeSorter.sort( input );
        int lastNumber = actual[0];

        for ( int i = 0; i < n; i++ ) {

            assertTrue( actual[i] >= lastNumber );
            lastNumber = actual[i];
        }
    }
}
