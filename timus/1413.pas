var x,y,u,v:longint;
kx,ky:extended;
c:char;
begin
   FillChar(x,ofs(c)-ofs(x)+SizeOf(c),0);
   repeat
     Read(c);
     case c of
       '0':break;
       '1':dec(u);
       '2':dec(y);
       '3':dec(v);
       '4':dec(x);
       '6':inc(x);
       '7':inc(v);
       '8':inc(y);
       '9':inc(u);
     end;
   until Eoln;
   kx:=x+(u-v)/sqrt(2);
   ky:=y+(u+v)/sqrt(2);
   Writeln(kx:0:10,' ',ky:0:10);
end.