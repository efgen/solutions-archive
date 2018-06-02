var a:array[1..100] of string;
b:array[1..100] of array[0..100] of integer;
n,m,i,j,p,k,ni,kol_vo,poss:integer;
pr:set of byte;
s:string;
flag:boolean;
begin
  FillChar(b,SizeOf(n),0);
  Readln(n); pr:=[];
  for i:=1 to n do
  begin
    Readln(a[i]);
    pr:=pr+[i];
  end;
  Readln(k);
  Readln(ni); poss:=n-ni;
  for i:=1 to ni do
  begin
    Readln(s);
    for j:=1 to n do
      if a[j]=s then pr:=pr-[j];
  end;
  for i:=1 to k do
  begin
    Readln(ni);
    for j:=1 to ni do
    begin
      Readln(s);
      p:=1;
      while p<=n do
      begin
        if a[p]=s then break;
        inc(p);
      end;
      inc(b[i,0]); b[i,p]:=1;
    end;
  end;
  Readln(m);
  for i:=1 to k do
  begin
    kol_vo:=0;
    flag:=true;
    for j:=1 to n do
      if b[i,j]=1 then
        if j in pr then
        begin
          flag:=false;
          inc(kol_vo);
        end;
    if flag  then Writeln('YES') else
      if kol_vo+m > poss then Writeln('NO') else Writeln('MAYBE');
  end;
end.