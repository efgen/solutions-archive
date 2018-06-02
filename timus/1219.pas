var i : longint;
begin
randomize;
for i:=1 to 1000000 do 
write(chr(random(26)+ord('a')));
writeln;
end.