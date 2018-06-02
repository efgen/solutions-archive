var a:array[0..100,0..100] of boolean;
n,i,j,kol_vo:byte;
pipl,t1,t2:set of byte;
flag:boolean;

begin
  FillChar(a,SizeOf(a),false);
  Readln(n);
  for i:=1 to n do
    repeat
      Read(j);
      a[i,j]:=true;
      a[j,i]:=true;
    until j=0;
  pipl:=[]; t1:=[]; t2:=[];
  for i:=1 to n do pipl:=pipl+[i];

  for i:=1 to n do
  begin
    flag:=false;
    for j:=1 to n do flag:=flag or a[i,j];
    if not(flag) then begin Writeln(0); halt; end;
    if i in pipl then
    begin
      pipl:=pipl-[i];
      t1:=t1+[i];
      for j:=1 to n do
        if a[i,j] then
        begin t2:=t2+[j]; pipl:=pipl-[j]; end;
    end;
  end;

  kol_vo:=0;
  for i:=1 to n do
    if i in t1 then inc(kol_vo);
  Writeln(kol_vo);
  for i:=1 to n do
    if i in t1 then Write(i,' ');
  Writeln;
end.