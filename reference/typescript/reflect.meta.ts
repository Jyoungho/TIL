import "reflect-metadata"; // 'Reflect'라는 global object를 생성한다.

const user = {
  firstName: "정민",
};

// 'user'에 `phone: '010-1234-5678'`이라는 metadata property를 추가한다.
console.log(user);
Reflect.defineMetadata("phone", "010-1234-5678", user);

// 'user.firstName'에 `lastName: '박'`이라는 metadata property를 추가한다.
Reflect.defineMetadata("lastName", "박", user, "firstName");
console.log(user);

// 'user'에서 'phone'을 key로 가지는 metadata value를 가져온다.
const number = Reflect.getMetadata("phone", user);
console.log(number);

const own = Reflect.getOwnMetadata("lastName", user, "firstName");
console.log("--");
console.log(own);

// 'user.firstName'에서 'lastName'을 key로 가지는 metadata value를 가져온다.
const lastName = Reflect.getMetadata("lastName", user, "firstName");
console.log(lastName);

// function concat(left: string, right: string): string {
//   return left + right;
// }

// let hello: string = concat("hello", "world");

// console.log(hello);
