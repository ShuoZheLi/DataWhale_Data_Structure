import java.util.ArrayList;
import java.util.LinkedList;

public class SortTrainSections{

    // 对k个队列进行初始化
    public static ArrayList<LinkedList<Integer>> initTrackList(int k) {
        ArrayList<LinkedList<Integer>> trackList = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < k; i++) {
            trackList.add(new LinkedList<Integer>());
        }
        return trackList;
    }

    // 考察每个队列的对头元素
    public static boolean testTrackFirst(int nowOut,
            ArrayList<LinkedList<Integer>> trackList) {
        for (int i = 0; i < trackList.size(); i++) {
            LinkedList<Integer> track = trackList.get(i);

            if (track.isEmpty()) {
                continue;
            }
            int firstEle = track.getFirst();
            if (firstEle == nowOut) {
                System.out.print("输出" + nowOut);
                track.removeFirst();
                return true;
            }
        }
        return false;
    }

    // 考察每个队列的队尾元素
    public static boolean testTrackLast(int now,
            ArrayList<LinkedList<Integer>> trackList) {
        int maxLast = 0;
        int index = -1;
        for (int i = 0; i < trackList.size(); i++) {
            LinkedList<Integer> track = trackList.get(i);

            if (track.isEmpty()) {
                continue;
            }
            int lastEle = track.getLast();

            if (maxLast < lastEle && lastEle < now) {
                maxLast = lastEle;
                index = i;
            }
        }
        if (index != -1) {
            trackList.get(index).add(now);
            return true;
        }
        return false;
    }

    // 判断是否存在空轨道
    public static boolean testEmptyTrack(int now,
            ArrayList<LinkedList<Integer>> trackList) {
        for (int i = 0; i < trackList.size(); i++) {
            LinkedList<Integer> track = trackList.get(i);
            if (track.isEmpty()) {
                track.add(now);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 6, 9, 2, 4, 7, 1, 8, 5 };
        ArrayList<LinkedList<Integer>> trackList = initTrackList(2);
        int nowOut = 1;
        //依次处理待排项
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            int now = arr[i];

            //如果当前项与即将输出的相符
            if (now == nowOut) {
                System.out.print("输出" + nowOut);
                nowOut++;
                continue;
            }

            //如果缓冲轨道中有队头元素与待输出项相符
            if (testTrackFirst(nowOut, trackList)) {
                nowOut++;

                //继续判断缓冲轨道中是否有队头元素与待输出项相符
                while(testTrackFirst(nowOut, trackList)){
                    nowOut++;
                }
                //判断当前项与待输出项是否相符
                if (now == nowOut) {
                    System.out.print("输出" + nowOut);
                    nowOut++;
                    continue;
                }
                //将当前项插入合适的队尾
                if (testTrackLast(now, trackList)) {
                    continue;
                }

                //将当前项插入合适的空队。
                if (testEmptyTrack(now, trackList)) {
                    continue;
                } else {
                    System.out.println("无法重排");
                }
            }

            if (testTrackLast(now, trackList)) {
                continue;
            }

            if (testEmptyTrack(now, trackList)) {
                continue;
            } else {
                System.out.println("无法重排");
            }
        }
        //处理好待排项之后处理缓冲
        while(nowOut <= arr.length){
            testTrackFirst(nowOut, trackList) ;
            nowOut++;
        }
    }
}