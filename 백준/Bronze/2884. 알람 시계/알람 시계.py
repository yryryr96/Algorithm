# a,b=map(int,input().split())
# a,b,c=map(int,input().split())
# 대문자 아스키 65~90
# 소문자 아스키 97~122
# List=[[_ for _ in range(5)] for _ in range(3)] >> 3*5 행렬 선언
# List=[i**3 for i in range()] >> i^3 을 리스트값으로 추가하며 리스트 선언

H,M=map(int,input().split())

# 0<=H<=23 , 0 <= M <= 59

if M-45 >= 0 :
    print(H,M-45)

elif M-45 < 0 :
    H=H-1
    if(H<0):
        H=23
    M=15+M
    print(H,M)