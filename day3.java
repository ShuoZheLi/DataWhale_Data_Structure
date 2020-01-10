import java.util.ArrayList;
import java.util.LinkedList;

public class SortTrainSections{

    // ��k�����н��г�ʼ��
    public static ArrayList<LinkedList<Integer>> initTrackList(int k) {
        ArrayList<LinkedList<Integer>> trackList = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < k; i++) {
            trackList.add(new LinkedList<Integer>());
        }
        return trackList;
    }

    // ����ÿ�����еĶ�ͷԪ��
    public static boolean testTrackFirst(int nowOut,
            ArrayList<LinkedList<Integer>> trackList) {
        for (int i = 0; i < trackList.size(); i++) {
            LinkedList<Integer> track = trackList.get(i);

            if (track.isEmpty()) {
                continue;
            }
            int firstEle = track.getFirst();
            if (firstEle == nowOut) {
                System.out.print("���" + nowOut);
                track.removeFirst();
                return true;
            }
        }
        return false;
    }

    // ����ÿ�����еĶ�βԪ��
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

    // �ж��Ƿ���ڿչ��
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
        //���δ��������
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            int now = arr[i];

            //�����ǰ���뼴����������
            if (now == nowOut) {
                System.out.print("���" + nowOut);
                nowOut++;
                continue;
            }

            //������������ж�ͷԪ�������������
            if (testTrackFirst(nowOut, trackList)) {
                nowOut++;

                //�����жϻ��������Ƿ��ж�ͷԪ�������������
                while(testTrackFirst(nowOut, trackList)){
                    nowOut++;
                }
                //�жϵ�ǰ�����������Ƿ����
                if (now == nowOut) {
                    System.out.print("���" + nowOut);
                    nowOut++;
                    continue;
                }
                //����ǰ�������ʵĶ�β
                if (testTrackLast(now, trackList)) {
                    continue;
                }

                //����ǰ�������ʵĿնӡ�
                if (testEmptyTrack(now, trackList)) {
                    continue;
                } else {
                    System.out.println("�޷�����");
                }
            }

            if (testTrackLast(now, trackList)) {
                continue;
            }

            if (testEmptyTrack(now, trackList)) {
                continue;
            } else {
                System.out.println("�޷�����");
            }
        }
        //����ô�����֮������
        while(nowOut <= arr.length){
            testTrackFirst(nowOut, trackList) ;
            nowOut++;
        }
    }
}