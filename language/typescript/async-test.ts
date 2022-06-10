// async 함수는 항상 Promise 를 반환한다. Promise 아닌 값을 반환하더라도 이행 상태 Promise(resolved promise)
// 로 값을 감싸 이행된 Promise 가 반환된다.
async function f() {
  const awaitResult = await awaitf();
  console.log("----");
  console.log(awaitResult);
  console.log("----");
  return awaitResult;
}

async function awaitf() {
  return 2;
}

let resultValue;
(async () => {
  console.log("first async");

  // await 함수는 async 하위에서만 실행되어야 한다.
  // await 함수 뒤에 실행되는 부분은 순서에 대한 고려가 필요하다.
  // await 함수 뒤에 실행하는 부분은 언제 실행되는지 정확히 알 수 없으며, anonymous에서 실행되지는 않는다.
  const result = await f();
  console.log(result);
  resultValue = result;
  console.log(resultValue);
})();

console.log(resultValue);
