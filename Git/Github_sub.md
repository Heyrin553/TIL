# Git

코드 관리 도구 



## SCM & VCS 

> git은 **버전**을 통해 **코드를 관리**하는 도구 

- SCM(Source Code Management): 코드 관리 
  - 프로그래밍 (소스)코드란? 컴퓨터에게 명령을 내리기 위한 글 
  
- VCS(Version Control System): 버전 관리 시스템



## Git 명령어

Git은 **폴더 단위**로 코드를 관리



### (1) `git init`

특정 폴더(저장소, 프로젝트)에서 git을 시작==특정 폴더를 git으로 관리하기 시작한다 

``` bash
$ git init
Initialized empty Git repository in C:/Users/혜린/test/.git/
```

1. `(master)`라는 표시가 프롬프트에 생성
2. `.git` 폴더가 생성



- `.git`폴더 삭제 시, git 관리 중지(git을 삭제)

  ```bash
  $ rm -r .git/
  ```

  

### (2) `git status`

git의 현재 상태를 출력 

- 최초상태(파일 없음)

```bash
$ git status

On branch master 

No commits yet
-> 아직 버전이 없다. 
nothing to commit (create/copy files and use "git add" to track)
-> 할 게 없다. 
```

- 파일 생성(`touch a.txt`)

```bash
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        a.txt
-> 추적되지 않는 파일
	(git add <특정파일>을 해줘, 버전(스냅샷)에 포함시키고 싶으면)

nothing added to commit but untracked files present (use "git add" to track)
-> 아직 commit할 수 없다. 추적되지 않는 파일은 있다. (add 해라)
```

- `git add a.txt`명령어 실행 후,  

```bash
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   a.txt
-> 버전으로 commit할 변화가 있다. (== commit할 수 있다.)
```

- `git comit`실행 후, 

```bash
On branch master
nothing to commit, working tree clean
-> 할 게 없다. 
```



### `git add [파일명]`



### `git commit -m "커밋 메시지"`

특정 상태를 스냅샷으로 찍어 버전을 만듦

1. 누가 찍었는지(author)
2. 언제 찍었는지(date)
3. 어떤 내용을 찍었는지(message) 



### `git log`

지금까지 기록된 Commit(==버전==스냅샷)을 출력

- git log --online



### `git diff [파일명]`

차이 확인 



### `git remote`

원격 저장소 정보를 출력

- `git remote add [이름] [주소]`
  - `git remote add  origin https://github.com/Heyrin553/test.git`
- `git remote -v`: verbose 모드



### `git push [이름] [브랜치]`

- git push origin master



### `git rm --cached`

스테이징에서 빼기 



git clone [url]

해당 프로젝트가 없을 때 그대로 복제해 오는 경우. 

0개 -> 12개 



git pull 

- 차이를 가져오기 

- `git pull origin master`



________

### `git config`

- `git config --global user.email [본인 이메일]`: 이메일을 조회/설정

- `git config --global user.name [본인 이름]`: 이름 조회/설정



|            |                                                              |
| ---------- | ------------------------------------------------------------ |
| git init   | 현재 폴더를 git으로 관리하기 시작                            |
| git status | 상태 확인(버전이 새로 추가되었는지 등의 상태 확인 )          |
| git add    | 어떤 파일을 commit할지(버전으로 찍을지) stage(==index)에 올리는 행위<br>무대에 올리기 |
| git commit | 버전 만들기                                                  |
| git log    | 버전 기록 출력하기                                           |
| got config | 이메일, 이름 설정                                            |





