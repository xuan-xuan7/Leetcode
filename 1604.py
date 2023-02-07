import collections


class Solution:
    def alertNames(self, keyName: List[str], keyTime: List[str]) -> List[str]:
        usedTime = collections.defaultdict(list)
        for i in range(len(keyName)):
            name = keyName[i]
            time = keyTime[i]
            hour = int(time[:2])
            min = int(time[3:])
            usedTime[name].append(hour * 60 + min)

        alert = []
        for name, times in usedTime.items():
            if len(times) < 3:
                continue
            else:
                times.sort()
            for i in range(len(times) - 2):
                if times[i + 2] - times[i] <= 60:
                    alert.append(name)
                    break
        alert.sort() 
        return alert
