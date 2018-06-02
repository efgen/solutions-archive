var n:integer;
begin
  Readln(n);
  case n of
    0,3..100:Writeln('-1');
    1:Writeln('1 2 3');
    2:Writeln('3 4 5')  
  end;
end.