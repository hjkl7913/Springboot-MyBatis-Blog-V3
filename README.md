# 스프링 부트 블로그 만들기

## 1. 개발 환경

- Springboot
- MyBatis
- MySQL
- JSP
- Spring Security
- Lombok

## 2. 요구사항(기능)

- 회원가입
- 로그인
- 사용자 프로파일(사진) 업로드
- 게시글 등록
- 게시글 수정
- 게시글 삭제
- 게시글 목록
- 게시글 상세보기
- 게시글 페이징
- 게시글 검색
- 게시글 권한 관리
- 댓글 등록
- 댓글 삭제

## 3. 테이블

```sql
create user 'spring'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'spring'@'%';
create database spring;
use spring;
```

```sql
CREATE TABLE user(
   id int auto_increment primary key,
    username varchar(100) unique not null,
```
