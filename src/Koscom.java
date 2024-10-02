import java.util.*;

public class Koscom {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // 시작 시간 측정
        Long A = 812551225602152L;

        HashSet<Long> hashSet = new HashSet<>();
        for(long i = 1; i <= Math.sqrt(A);i++){
            if(A % i == 0 ){
                hashSet.add(i);
                hashSet.add(A/i);
            }
        }
        hashSet.remove(1L);
        long maxNum = 0;
        long minCount = Long.MAX_VALUE;

        for(long l : hashSet){
            HashSet<Long> hashSet2 = new HashSet<>();
            for(long i = 1; i <= Math.sqrt(l);i++){
                if(l % i == 0 ){
                    hashSet2.add(l);
                    hashSet2.add(l/i);
                }
            }
            if(hashSet2.size() < minCount){
                maxNum = l;
                minCount = hashSet2.size();
            }else if(hashSet2.size() == minCount){
                if(maxNum <= l) maxNum = l;
            }
        }


        long endTime = System.currentTimeMillis(); // 종료 시간 측정
        System.out.println("Execution time: " + (endTime - startTime) + " ms"); // 실행 시간 출력
        System.out.println(maxNum);
    }

}
