package org.mjeorrett.java.mergesorttest;

/**
 * Created by user on 21/11/2016.
 */

public class MergeSorter {

    public static int[] sort( int[] inputArr ) {

        if ( inputArr.length == 1 ) {

            return inputArr;
        }

        int inArrayLength = inputArr.length;
        int[][] workingArrays = new int[inArrayLength][1];

        for ( int i = 0; i < inArrayLength; i++ ) {

            workingArrays[i][0] = inputArr[i];
        }

        while ( workingArrays.length > 1 ) {

            workingArrays = mergeSortArrays( workingArrays, inArrayLength );
        }

        int[] result = new int[inArrayLength];

        for ( int i = 0; i < inArrayLength; i++ ) {

            result[i] = workingArrays[0][i];
        }

        return result;
    }

    private static int[][] mergeSortArrays( int[][] inArrays, int dataLength ) {

        int inArrayCount = inArrays.length;
        int inArrayLength = inArrays[0].length;

        int outArrayCount = (int) Math.ceil( inArrayCount / 2.0 );
        int outArrayLength = inArrayLength * 2;
        int[][] outArrays = new int[outArrayCount][outArrayLength];
        int iOutArray = 0;
        int outArrayIndex = 0;
        int outArrayPosition = ( iOutArray * outArrayLength ) + outArrayIndex;

        int iInArray1 = 0;
        int inArray1Index = 0;
        int inArray1Value = 0;

        int iInArray2 = 1;
        int inArray2Index = 0;
        int inArray2Position = (iInArray2 * inArrayLength) + inArray2Index;
        int inArray2Value = 0;

        int nextValue;

        while ( outArrayPosition < dataLength ) {

            if ( inArray1Index < inArrayLength ) {

                inArray1Value = inArrays[iInArray1][inArray1Index];
            }

            if ( inArray2Position < dataLength && inArray2Index < inArrayLength ) {

                inArray2Value = inArrays[iInArray2][inArray2Index];
            }

            if ( inArray1Index < inArrayLength && (inArray2Position >= dataLength || inArray2Index >= inArrayLength || inArray1Value < inArray2Value) ) {

                nextValue = inArray1Value;
                inArray1Index++;

            } else {

                nextValue = inArray2Value;
                inArray2Index++;
            }

            outArrays[iOutArray][outArrayIndex] = nextValue;
            outArrayIndex++;

            if ( outArrayIndex >= outArrayLength ) {

                outArrayIndex = 0;
                iOutArray++;
            }

            outArrayPosition = (iOutArray * outArrayLength) + outArrayIndex;

            if ( inArray1Index >= inArrayLength && inArray2Index >= inArrayLength ) {

                iInArray1 += 2;
                inArray1Index = 0;

                iInArray2 += 2;
                inArray2Index = 0;
            }

            inArray2Position = (iInArray2 * inArrayLength) + inArray2Index;
        }

        return outArrays;
    }

}
