var pr:array [1..15000] of longint;
  k,i,j,a,n:longint;

begin
  pr[1]:=2; pr[2]:=3; pr[3]:=5; pr[4]:=7;
  i:=5; n:=11;

  while i<=15000 do
  begin
     j:=2;
     while pr[j]<=round(sqrt(n)) do
     begin
       if n mod pr[j] = 0 then
       begin
         j:=0;
         break;
       end;
       inc(j);
     end;
     if j<>0 then begin pr[i]:=n; inc(i); end;
     n:=n+2;
  end;


  Readln(k);  i:=1;
  while i<=k do
  begin
    Read(a);
    Writeln(pr[a]);
    inc(i);
  end;
end.