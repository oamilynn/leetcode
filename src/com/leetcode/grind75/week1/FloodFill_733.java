package com.leetcode.grind75.week1;

public class FloodFill_733 {

    private int[][] newImage;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        newImage = image.clone();
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            floodFill(sr, sc, oldColor, color);
        }
        return newImage;
    }

    public void floodFill(int sr, int sc, int color, int newColor) {
        if (sr < 0 || sc < 0 || sr >= newImage.length || sc >= newImage[0].length) {
            return;
        }
        if (newImage[sr][sc] == color) {
            newImage[sr][sc] = newColor;
            floodFill(sr - 1, sc, color, newColor);
            floodFill(sr + 1, sc, color, newColor);
            floodFill(sr, sc - 1, color, newColor);
            floodFill(sr, sc + 1, color, newColor);
        }
    }

}
