{$APPTYPE CONSOLE}
uses SysUtils;
const n = 1000000;
var a:array[0..n] of integer;
i,j,k,x,all,p,r:integer;
s,com:string;
eps,res:extended;

function prev(x:integer):integer;
begin
  Result:=x and (x-1);
end;
function next(x:integer):integer;
begin
  Result:=(x shl 1) - (x and (x-1));
end;
procedure modif(x,val:integer);
begin
  inc(all,val);
  while x<=n do
  begin
    inc(a[x],val);
    x:=next(x);
  end;
end;
function sum(x:integer):integer;
var res:integer;
begin
  res:=all; dec(x);
  while x>0 do
  begin
    dec(res,a[x]);
    x:=prev(x);
  end;
  Result:=res;
end;

begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);     }
  eps:=1e-7;
  FillChar(a,SizeOf(a),0);
  all:=0; res:=0;
  DecimalSeparator:='.';
  while true do
  begin
    Readln(s);
    case s[1] of
      'B':
      begin
        x:=Round((StrToFloat(Copy(s,Pos(' ',s)+1,length(s)))+eps)*100);
        modif(x,1);
    //    Writeln(x);
      end;
      'D':
       begin
        x:=Round((StrToFloat(Copy(s,Pos(' ',s)+1,length(s)))+eps)*100);
        modif(x,-1);
      end;
      'S':
      begin
        s:=Copy(s,Pos(' ',s)+1,length(s));
        p:=Pos(' ',s);
        x:=Round((StrToFloat(Copy(s,1,p-1))+eps)*100);
        k:=StrToInt(Copy(s,p+1,length(s)));
        r:=sum(x);
        if r>k then r:=k;
        res:=res+r/100;
    //    Writeln(x);
      end;
      'Q':break;
    end;
  end;

  Writeln(res:0:2);
//  Close(input);Close(output);
end.
