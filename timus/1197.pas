{#1197 7.09.2005 year lec1}

  type koord = record
    i,j:integer;
  end;
  var i,j,k,n:integer;
  s:string;
  data:array[1..100] of  koord;

function BitFil(i,j:integer):integer;
var di,dj,n:integer;
begin
  n:=0;
  for di:=-2 to 2 do
    for dj:=-2 to 2 do
    begin
      if (di=0) or (dj=0) or (di=dj) or (di+dj=0) then continue;
      if ((i+di)>8) or ((i+di)<1) or ((j+dj)>8) or ((j+dj)<1) then
        continue else inc(n);
    end;
  BitFil:=n;
end;

begin
  Readln(n);
  for k:=1 to n do
  begin
    Readln(s);
    data[k].i:=ord(s[1])-96;
    data[k].j:=ord(s[2])-48;
  end;

  for k:=1 to n do
    Writeln(BitFil(data[k].i,data[k].j));
end.