var s:string;
c:char;
Let:set of char;
f:boolean;
i:integer;

begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
 } let := ['a'..'z','A'..'Z'];
  f:=true;
  s:='';
  while not Eof do
  begin
    Read(c);
    if c in Let then
      if f then s:=s+c else begin s:=c; f:=true; end
    else
      if f then
      begin
        i:=length(S);
        while i>0 do begin  Write(s[i]); dec(i); end;
        S:='';
        f:=false;
        Write(c);
      end else Write(c);
  end;
  i:=length(S);
  while i>0 do begin  Write(s[i]); dec(i); end;
//  Close(input); Close(output);
end.
