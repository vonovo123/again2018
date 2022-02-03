## 자바 내부 함수의 정렬
###  JAVA의 Arrays.sort(arr)

primative 원소의 정렬
- dual quick sort
- 최선 O(N)
- 최악 O(N^2)
- 평균 O(Nlog2N)

Object원소의 정렬
- Tim sort
- 최선 O(N)
- 최악 O(Nlog2N)
- 평균 O(Nlog2N)

특성
- 같은 정보들은 인접해있다
- 각 원소마다, 자신과 비슷한(가까운) 원소는 양 옆에 있다.