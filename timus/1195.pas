var tt:array[0..20000] of integer;   
a:array[1..3,1..3] of integer;   
win,f:boolean;   
i,j,p:integer;   
s:string;   
function min(a,b:integer):integer;   
begin   
  if a < b then min:=a else min:=b;   
end;   
  
function max(a,b:integer):integer;   
begin   
  if a > b then max:=a else max:=b;   
end;   
function go(p:integer;k:integer):integer;   
var i,j,d:integer;   
begin   
  d:=p;   
  for i:=3 downto 1 do   
    for j:=3 downto 1 do   
    begin   
      a[i,j]:=d mod 3;   
      d:=d div 3;   
    end;   
  win:=false;   
  for i:=1 to 3 do   
  begin   
    if (a[i][1]>0) and (a[i][1]=a[i][2]) and (a[i][1]=a[i][3]) then win:=true;   
    if (a[1][i]>0) and (a[1][i]=a[2][i]) and (a[1][i]=a[3][i]) then win:=true;   
  end;   
  win:=win or ((a[1][1]>0) and (a[1][1]=a[2][2]) and (a[1][1]=a[3][3]));   
  win:=win or ((a[3][1]>0) and (a[3][1]=a[2][2]) and (a[3][1]=a[1][3]));   
  if win then   
  begin   
    if k mod 2 = 0 then tt[p]:=1 else tt[p]:=3;   
    Result:=tt[p];   
    exit;   
  end;   
   if k = 10 then begin tt[p]:=2; Result:=2;exit; end;   
  d:=1;   
  if k mod 2 = 1 then tt[p]:=3 else tt[p]:=1;   
  for i:=1 to 3 do   
      for j:=1 to 3 do   
    begin   
      if (p div d) mod 3 = 0 then   
        if k mod 2 = 1 then tt[p]:=min(tt[p],go(p+d,k+1)) else tt[p]:=max(tt[p],go(p+d+d,k+1));   
      d:=d*3;   
    end;   
    Result:=tt[p];   
end;   
begin  
  FillChar(tt,SizeOf(tt),0);   
  go(0,1);   
  p:=0;   
  for i:=1 to 3 do   
  begin   
    Readln(s);   
    for j:=1 to 3 do   
    begin   
      p:=p*3;   
      if s[j]='X' then p:=p+1 else   
      if s[j]='O' then p:=p+2;   
    end;   
  end;   
  
  if tt[p] = 0 then Write('Impossible') else   
    if tt[p] = 1 then Write('Crosses win') else   
      if tt[p] = 2 then Write('Draw') else Write('Ouths win'); 
  
  
end.   