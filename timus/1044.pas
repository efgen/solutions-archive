var n,sum,max,num,i:longint;
    a:array [0..36] of longint;
begin
  FillChar(a,SizeOf(a),0);
  Readln(n);
  n:=n div 2;
  max:=1;
  for i:=1 to n do max:=max*10; dec(max);
  for i:=1 to max do
  begin
    sum:=0; num:=i;
    while num>0 do
    begin
      sum:=sum+num mod 10;
      num:=num div 10;
    end;
    inc(a[sum]);
  end;
  sum:=1;
  for i:=1 to 36 do sum:=sum+(a[i]*a[i]);
  Writeln(sum);
end.