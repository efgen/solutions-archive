{$APPTYPE CONSOLE}
var s,sd:string;
c:char;
i,len,p,t:integer;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);      }
  s:=''; sd:='';
  repeat
    Read(c);
    if c=#13 then break else s:=s+c;
  until false;
  len:=length(s);
  p:=2; sd:=s[1];
  while p<len do
    if s[p]<>s[len] then
    begin
      sd:=s[p]+sd;
      inc(p);
    end else
    begin
      t:=1;
      while (s[p+t]=s[len-t]) and (p+t<=len-t) do inc(t);
      if (p+t>len-t) and (s[p+t-1]=s[len-t+1])  then
      begin
        Writeln(s,sd);
        Close(input); Close(output);
        halt(0);
      end else
      begin
        sd:=s[p]+sd;
        inc(p);
      end;
    end;
  Writeln(s,sd);
 // Close(input); Close(output);
end.