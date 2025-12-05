package org.example.task_73;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        int n = words.length;

        while (index < n) {
            int start = index;
            int wordLengthSum = words[index].length();
            index++;

            while (index < n && wordLengthSum + 1 + words[index].length() <= maxWidth) {
                wordLengthSum += 1 + words[index].length();
                index++;
            }

            int wordCount = index - start;
            int gapCount = wordCount - 1;
            int totalSpaces = maxWidth - (wordLengthSum - gapCount);

            StringBuilder line = new StringBuilder();

            if (index == n || gapCount == 0) {
                for (int k = start; k < index; k++) {
                    if (k > start) line.append(" ");
                    line.append(words[k]);
                }
                while (line.length() < maxWidth) line.append(" ");
            } else {
                int evenSpaces = totalSpaces / gapCount;
                int extraSpaces = totalSpaces % gapCount;

                for (int k = start; k < index; k++) {
                    line.append(words[k]);
                    if (k < index - 1) {
                        int spacesHere = evenSpaces + (extraSpaces-- > 0 ? 1 : 0);
                        line.append(" ".repeat(spacesHere));
                    }
                }
            }
            result.add(line.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        System.out.println(fullJustify(words, maxWidth));
    }
}