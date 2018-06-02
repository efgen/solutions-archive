{$APPTYPE CONSOLE}
const inf = 1000000000;
var a:array[1..100,1..100] of integer;
b,d,f:array[1..100] of integer;

i,j,k,n,m,l,hum,s,best,res:integer;
fl:boolean;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);  }
  Read(n,m);
  for i:=1 to n do
    for j:=1 to n do
      a[i,j]:=inf;
  while m>0 do
  begin
    dec(m);
    Read(l);
    for i:=1 to l do Read(b[i]);
    for i:=1 to l do
      for j:=1 to l do
        a[b[i],b[j]]:=4;
  end;
  for i:=1 to n do a[i,i]:=0;
  Read(hum);
  for i:=1 to hum do Read(d[i],b[i],f[i]);
  for k:=1 to n do
    for i:=1 to n do
      for j:=1 to n do
        if (a[i,k]<inf) and (a[k,j]<inf) then
        if a[i,k]+a[k,j]<a[i,j] then a[i,j]:=a[i,k]+a[k,j];
  k:=hum; best:=inf;
  for i:=1 to n do
  begin
    fl:=true; s:=0;
    for j:=1 to k do
      if a[i,b[j]]=inf then
      begin
        fl:=false;
        break;
      end else
      if f[j]=0 then
        if d[j]<a[i,b[j]] then
        begin
          fl:=false;
          break;
        end else s:=s+a[i,b[j]];
    if not (fl) then continue;
    if s<best then
    begin
      best:=s;
      res:=i;
    end;
  end;
  if best=inf then Write(0) else Write(res,' ',best);
//  Close(input); Close(output);
end.