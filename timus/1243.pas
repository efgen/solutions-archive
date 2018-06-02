var s:string;
    i,x,p,flag:integer;
begin
  Readln(s); i:=Length(s);
  p:=0;  flag:=0;
  while (i>0) do
  begin
    x:=ord(s[i])-48;
    case flag of
      0:p:=p+x;
      1:p:=p+3*x;
      2:p:=p+2*x;
      3:p:=p-x;
      4:p:=p-3*x;
      5:begin p:=p-2*x; flag:=-1; end;
    end;
    inc(flag);
    p:=(42+p) mod 7;
    dec(i);
  end;
  Writeln(p);
end.