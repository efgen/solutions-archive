var i,n:integer;
    x,y,z:longint;
    c:char;
    q:longint;


function min(a,b:longint):longint;
  begin
  if a<b then min:=a else min:=b;
  end;

function nonzero(q:longint):longint;
  begin
  if q=0 then nonzero:=0 else nonzero:=1;
  end;

begin
readln(n);
x:=0;
y:=0;
z:=0;
for i:=1 to n do begin
  read(c);
  if not (c in ['X','Y','Z']) then runerror(43);
  readln(q);
  if c='X' then x:=x+q;
  if c='Y' then begin x:=x+q; z:=z+q; end;
  if c='Z' then z:=z+q;
  end;
y:=0;
if (x>0) and (z>0) then y:=min(x,z);
if (x<0) and (z<0) then y:=-min(-x,-z);
x:=x-y;
z:=z-y;
writeln(nonzero(x)+nonzero(y)+nonzero(z));
if x<>0 then writeln('X ',-x);
if y<>0 then writeln('Y ',-y);
if z<>0 then writeln('Z ',-z);
end.
