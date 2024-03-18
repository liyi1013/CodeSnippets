import threading
from time import sleep


def fibonacci(n,name):
    global g
    fib = [0,1]
    for i in range(2,n):
        fib.append(fib[i-1]+fib[i-2])
        sleep(2)
        print(f"{name}, g={g}\n")
        g=g+1
    return fib

def calculate_fibonacci(n,tname):
    res = fibonacci(n,tname)
    print(f"fibonacci of {n} is {res}. {tname}")


if __name__=="__main__":
    global g # 2线程共享
    g=0
    n=10
    # 创建2线程
    thread1 = threading.Thread(target=calculate_fibonacci,args=(n,"thread1"))
    thread2 = threading.Thread(target=calculate_fibonacci,args=(n,"thread2"))

    thread1.start()
    sleep(10)
    thread2.start()

    print(threading.active_count())
    print(threading.current_thread())
    

    
    # 等待线程结束
    thread1.join()
    thread2.join()

    # 等待进程结束
    sleep(20)
    
    print("Done")