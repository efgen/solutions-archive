var
i,k,n,x:integer;
c:char;
a:array[1..250] of integer;
next,s:array[1..100000] of integer;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);   }
  FillChar(a,SizeOf(a),0);
  Readln(k); n:=0;
  while not Eof do
  begin
    Read(c);
    if (c=#26) or (c=#13) then break;
    inc(a[ord(c)]);
    inc(n);
    s[n]:=ord(c);
  end;
  x:=0;
  for i:=1 to 250 do
  begin
    x:=x+a[i];
    a[i]:=x-a[i]+1;
  end;
  for i:=1 to n do
  begin
    x:=s[i];
    next[a[x]]:=i;
    inc(a[x]);
  end;
//  for i:=1 to n do Write(next[i],' '); Writeln;
  for i:=1 to n do
  begin
    k:=next[k];
    Write(chr(s[k]));
  end;
 // Close(input);Close(output);
end.
