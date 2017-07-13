package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int r, int c, Color desiredColor) {
        // image[c][r]

        if (c < 0 || c >= image.length || r < 0 || r >= image[c].length)
            return false;

        if (image[c][r] == desiredColor)
            return false;

        Color forChanging = image[c][r];
        image[c][r] = desiredColor;
        for (int rr = r-1; rr <= r+1; rr++) {
            for (int cc = c-1; cc <= c+1; cc++) {
                if (cc < 0 || cc >= image.length || rr < 0 || rr >= image[cc].length)
                    continue;
                if (image[cc][rr] == forChanging) {
                    paintFill(image, rr, cc, desiredColor);
                }
            }
        }

        return true;
    }
}
