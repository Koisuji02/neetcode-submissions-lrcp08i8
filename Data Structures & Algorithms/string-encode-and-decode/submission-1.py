class Solution:

    def encode(self, strs: List[str]) -> str:
        res = [];
        for s in strs:
            # salvo in formato len:stringa -> "4:ciao"
            res.append(str(len(s)) + ":" + s)
        return "".join(res)

    def decode(self, s: str) -> List[str]:
        i = 0
        out = []
        while i < len(s):
            # trova la pos di ":"
            j = s.find(":", i)
            
            if j == -1: # errore input
                break
            
            # length = lunghezza stringa salvata prima di ":"
            length = int(s[i:j])
            # i = sposto indice fino all'inizio della stringa (dopo ":")
            i = j + 1
            # aggiungo ad out la singola stringa
            out.append(s[i:i+length])
            i += length

        return out
