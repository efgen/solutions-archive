type table = record
  a:array['A'..'Z'] of integer;
  b:array['A'..'Z'] of array['a'..'z'] of integer;
end;

var s,exp:string;
c:char;
f1,f:table;
p,n,i:integer;
procedure next();
begin
  if p<length(s) then
  begin
    inc(p);
    c:=s[p];
  end else c:='.';
end;
procedure sequence(var t:table); forward;

procedure init(var t:table);
begin
  FillChar(t.a,SizeOf(t.a),0);
  FillChar(t.b,SizeOf(t.b),0);
end;
procedure mul(var t:table;n:integer);
var c,c2:char;
begin
  for c:='A' to 'Z' do t.a[c]:=t.a[c]*n;
  for c:='A' to 'Z' do
    for c2:='a' to 'z' do
      t.b[c,c2]:=t.b[c,c2]*n;
end;
procedure add(var t,dt:table);
var c,c2:char;
begin
  for c:='A' to 'Z' do t.a[c]:=t.a[c]+dt.a[c];
  for c:='A' to 'Z' do
    for c2:='a' to 'z' do
      t.b[c,c2]:=t.b[c,c2]+dt.b[c,c2];
end;
function equal(var t1,t2:table):boolean;
var c,c2:char;
f:boolean;
begin
  f:=true;
  for c:='A' to 'Z' do f:=f and (t1.a[c]=t2.a[c]);
  for c:='A' to 'Z' do
    for c2:='a' to 'z' do
      f:=f and (t1.b[c,c2]=t2.b[c,c2]);
  Result:=f;
end;


procedure number(var n:integer);
begin
  if c in ['0'..'9'] then
  begin
    n:=ord(c)-ord('0');
    next();
    while c in ['0'..'9'] do
    begin
      n:=10*n+ord(c)-ord('0');
      next();
    end;
  end else n:=1;
end;
procedure chem(var t:table);
var ch:char;
begin
  init(t);
  ch:=c;
  next();
  if c in ['a'..'z'] then
  begin
    t.b[ch,c]:=1;
    next();
  end else t.a[ch]:=1;
end;
procedure elem(var t:table);
var n:integer;
begin
  if c = '(' then
  begin
    next();
    sequence(t);
    next();
  end else chem(t);
end;
procedure sequence(var t:table);
var n:integer;
t2:table;
begin
  elem(t);
  number(n);
  mul(t,n);
  while c in ['A'..'Z','('] do
  begin
    elem(t2);
    number(n);
    mul(t2,n);
    add(t,t2);
  end;
end;
procedure formula(var t:table);
var n:integer;
t2:table;
begin
  next();
  init(t);
  number(n);
  sequence(t);
  mul(t,n);
  while c = '+' do
  begin
    next();
    number(n);
    sequence(t2);
    mul(t2,n);
    add(t,t2);
  end;
end;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);  }
  Readln(s); exp:=s; p:=0;
  formula(f1);
 {  for c:='A' to 'Z' do
      if f1.a[c]>0 then Writeln(c,' ',f1.a[c]);  }
  Readln(n);
  for i:=1 to n do
  begin
    Readln(s); p:=0;
    formula(f);
    if equal(f,f1) then
      Writeln(exp,'==',s)
    else
      Writeln(exp,'!=',s);    
 {   for c:='A' to 'Z' do
      if f.a[c]>0 then Writeln(c,' ',f.a[c]);         }
  end;  
//  Close(input);Close(output);
end.
