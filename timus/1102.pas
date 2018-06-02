program Zz;
{$APPTYPE CONSOLE}
var s:string;
i,test:integer;
function tup(var i:integer):boolean;
begin
  Result:=false;
  if (i>0) and (s[i]='t') then dec(i) else exit;
  if (i>0) and (s[i]='u') then dec(i) else exit;
  if (i>0) and (s[i]='p') then dec(i) else exit;
  Result:=true;
end;
function check(var i:integer):boolean;
begin
  if i = 0 then begin Result:=true; exit; end;
  Result:=false;
  while i>0 do
  begin
    case s[i] of
    'e':i:=i-3;
    'n': if (i>1) and (s[i-1]='i') then i:=i-2 else
         if (i>1) and (s[i-1]='o') then
         begin i:=i-2; if not tup(i) then exit; end else exit;
    't': if (i>1) and (s[i-1]='u') then
         begin
           i:=i-2;
           if i<=0 then exit;
           if s[i]='o' then dec(i) else
           if s[i]='p' then
           begin
             dec(i);
             if i<=0 then exit;
             if (i>1) and (s[i]='n') and (s[i-1]='i') then i:=i-2 else
             if (i>2) and (s[i]='t') and (s[i-1]='u') and (s[i-2]='o') then i:=i-3
               else exit;
           end else exit;
         end else exit;
    else exit;
    end;
  end;
  if i = 0 then Result:=true;
end;
begin
 { Assign(input,'test.in');
  Assign(output,'test.out');
  Reset(input); Rewrite(output);  }
  Readln(test);
  while test>0 do
  begin
    dec(test);
    Readln(s);
    i:=length(s);
    if check(i) then Writeln('YES') else Writeln('NO');
  end;
//  Close(input); Close(output);
end.