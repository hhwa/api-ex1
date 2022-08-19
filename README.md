springboot, h2 database, mybatis 사용


* 회원가입 기능 ( 인증 후 회원가입 )

1. 인증번호 전송
POST http://localhost:8080/certification/send

{
    "tel" : "수신받을번호"
}

curl -X POST http://localhost:8080/certification/send -H "Content-Type: application/json" -d '{"tel":"수신받을번호"}'

2. 인증번호 확인

POST http://localhost:8080/certification/confirms

{
    "tel" : "수신받을번호",
    "certificationNumber" : "인증번호"
}

curl -X POST http://localhost:8080/certification/confirms -H "Content-Type: application/json" -d '{"tel":"수신받을번호","certificationNumber" : "인증번호"}'

3. 회원가입

3-1. 닉네임 중복검사 ( curl -X GET http://localhost:8080/member/exists/nicknames/{nickname} )
3-2. 이메일 중복검사 ( curl -X GET http://localhost:8080/member/exists/emails/{email} )

POST http://localhost:8080/member/join
{
    "email" : "이메일",
    "password" : "비밀번호",
    "nickname" : "닉네임",
    "name" : "이름",
    "tel" : "전화번호"
}

curl -X POST http://localhost:8080/member/join -H "Content-Type: application/json" -d '{ "email" : "이메일", "password" : "비밀번호", "nickname" : "닉네임", "name" : "이름", "tel" : "전화번호" }'

* 로그인 기능 ( 이메일 or 닉네임 or 전화번호 + 비밀번호 로 로그인 ) - 세션에 로그인정보 저장

POST http://localhost:8080/login
{
    "email" : "이메일",
    "password" : "비밀번호"
}

curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{ "nickname" : "닉네임", "password" : "비밀번호" }

* 로그아웃

DELETE http://localhost:8080/logout

curl -X DELETE http://localhost:8080/logout

* 내 정보 보기 기능
- 세션체크( 로그인확인 ) 후 정보 출력

GET http://localhost:8080/myinfo

curl - X GET http://localhost:8080/myinfo

* 비밀번호 찾기(재설정) 기능 ( 인증 후 재설정 )

1. 인증번호 전송
POST http://localhost:8080/certification/send

{
    "tel" : "수신받을번호"
}

curl -X POST http://localhost:8080/certification/send -H "Content-Type: application/json" -d '{"tel":"수신받을번호"}'

2. 인증번호 확인

POST http://localhost:8080/certification/confirms

{
    "tel" : "수신받을번호",
    "certificationNumber" : "인증번호"
}

curl -X POST http://localhost:8080/certification/confirms -H "Content-Type: application/json" -d '{"tel":"수신받을번호","certificationNumber" : "인증번호"}'

3. 세션체크( 로그인 아닐때 ) / 인증상태일때

curl -X PATCH http://localhost:8080/searchPassword -H "Content-Type: application/json" -d '{"tel":"수신받을번호","certificationNumber" : "인증번호"}'
