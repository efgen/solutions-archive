{$APPTYPE CONSOLE}
var dm:array[1..12] of integer = (31,28,31,30,31,30,31,31,30,31,30,31);
d,m,y,p,t,n:integer;
a:array[0..6,1..6] of integer;
name:array[0..6] of string = ('mon','tue','wed','thu','fri','sat','sun');
function leap(x:integer):integer;
begin
  if (x mod 400 = 0) or ((x mod 4 = 0) and (x mod 100 <> 0))
  then Result:=1 else Result:=0;
end;

begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);  }
  Read(d,m,y); p:=0; t:=2007;
  inc(dm[2],leap(y));
  while  t<y do
  begin
    p:=(p+365+leap(t)) mod 7;
    inc(t);
  end;
  while t>y do
  begin
    dec(t);
    p:=(49*49*49+p-365-leap(t)) mod 7;
  end;

  for t:=1 to m-1 do
    p:=(p+dm[t]) mod 7;

   FillChar(a,SizeOf(a),0);  
  n:=1; dec(p);
  for t:=1 to dm[m] do
  begin
    inc(p);
    if p=7 then
    begin
      p:=0;
      inc(n);
    end;
    a[p,n]:=t;
  end;

  for p:=0 to 6 do
  begin
    Write(name[p]);
    for t:=1 to n do
    begin
      Write(' ');
      if a[p,t]=d then
        Write('[',a[p,t]:2,']')
      else
      if a[p,t]>0 then
      begin
        Write(' ',a[p,t]:2);
        if t<>n then Write(' ');
      end
      else
      begin
        Write('   ');
        if t<>n then Write(' ');
      end;
    end;
    Writeln;
  end;
//  Close(input);Close(output);
end.
