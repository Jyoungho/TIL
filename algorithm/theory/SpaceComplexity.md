## 공간복잡도

S(P) = c + Sp(N)
- c : 고정 공간 -> 코드저장 공간 / 변수 및 상수
- Sp(N) : 가변공간 -> 실행 중 동적으로 필요한 공간

공간복잡도 예시 (n!)
    
    O(1)
    result = 1;
    for (int i = 1; i <= n; i ++)  { 
        result = result *  i;
    }
    -> result, i, n 등의 변수공간은 일치하기 때문에 O(1)

    O(n)
    factorial(n) {
        if (n>1) {
            return = n * factorial(n-1);
        } else {
            return = 1;
        }
    }
    -> parameter n은 지역변수로 활용되고 함수가 실행되면서 n이 계속 호출되므로 O(n)   
        