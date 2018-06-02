var a,p:array[1..1003,1..1003] of boolean;
s1,s2:string;
i,j,k,n:integer;
c:char;
m1,m2:array[1..1003] of boolean;
res:string;
function solv(i,j:integer):boolean;
begin
  if i>n then
    if j>n then begin Result:=true; exit;end else
    begin
      Result:=false;
      if m2[j]<>m2[j+1] then
        if solv(i,j+2) then
        begin
           res:='22'+res;
           Result:=true;
        end;
        exit;
     end;
  if j>n then
  begin
    Result:=false;
    if m1[i]<>m1[i+1] then
      if solv(i+2,j) then
      begin
        res:='11'+res;
        Result:=true;
      end;
      exit;
  end;     
  if p[i,j] then begin Result:=a[i,j]; exit;end else p[i,j]:=true;
  if m1[i]<>m2[j] then
    if solv(i+1,j+1) then
    begin
      res:='12'+res;
      a[i,j]:=true;
      Result:=true;
      exit;
    end;
  if m1[i]<>m1[i+1] then
    if solv(i+2,j) then
    begin
      res:='11'+res;
      a[i,j]:=true;
      Result:=true;
      exit;
    end;
  if m2[j]<>m2[j+1] then
    if solv(i,j+2) then
    begin
      res:='22'+res;
      a[i,j]:=true;
      Result:=true;
      exit;
    end;
  a[i,j]:=false;
  Result:=false;
end;
begin
 
  Readln(n);
  Readln(s1);
  Readln(s2);
  for i:=1 to n do m1[i]:=s1[i]='1';
  for i:=1 to n do m2[i]:=s2[i]='1';
  FillChar(p,SizeOf(p),false);
  res:='';
  if solv(1,1) then Write(res) else  Write('Impossible');
end.